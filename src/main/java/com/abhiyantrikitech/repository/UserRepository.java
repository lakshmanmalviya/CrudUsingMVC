package com.abhiyantrikitech.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.abhiyantrikitech.dto.LoginRequest;
import com.abhiyantrikitech.dto.SignupRequest;
import com.abhiyantrikitech.dto.UserDto;
import com.abhiyantrikitech.exception.InvalidLoginException;
import com.abhiyantrikitech.exception.ResourceAlreadExists;
import com.abhiyantrikitech.util.JdbcConnection;

@Repository
public class UserRepository {

	@Autowired
	JdbcConnection con;

	public Optional<String> createUser(SignupRequest request, ModelMap model) {
		PreparedStatement st = null;
		Connection connection = null;
		try {
			if (userExistsByEmail(request.getEmail())) {
				throw new ResourceAlreadExists("User email already exists please try with other credentials");
			} else
				model.clear();

			connection = con.getConnection();
			st = connection.prepareStatement(
					"insert into users(firstName,lastName,email,password,age,contact) values(?,?,?,?,?,?)");
			st.setString(1, request.getFirstName());
			st.setString(2, request.getLastName());
			st.setString(3, request.getEmail());
			st.setString(4, request.getPassword());
			st.setString(5, request.getAge());
			st.setString(6, request.getContact());
			int i = st.executeUpdate();
			if (i >= 1) {
				model.put("success", "User registered successfully");
				return Optional.ofNullable("redirect:/");
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
			e.printStackTrace();
		}
		return Optional.ofNullable("signup");
	}

	public UserDto loginUser(LoginRequest request, ModelMap model) {
		try (Connection connection = con.getConnection()) {
			String query = String.format("select * from users where email=? and password=?");
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, request.getEmail());
			st.setString(2, request.getPassword());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				model.put("success", "logged in successfully");
				model.put("id", rs.getInt("id"));
				return findById(rs.getInt("id"));
			}
			throw new InvalidLoginException("Invalid credentials please enter the correct email and password");
		} catch (Exception e) {
			model.put("error", e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public boolean userExistsByEmail(String email) {
		try (Connection connection = con.getConnection()) {
			String query = String.format("select * from users where email=?");
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, email);
			return st.executeQuery().next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public UserDto findById(int id) {
		try (Connection connection = con.getConnection()) {
			UserDto user = new UserDto();
			String query = String.format("select * from users where id=?");
			PreparedStatement st = connection.prepareStatement(query);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setId(rs.getInt("id"));
				user.setContact(rs.getString("contact"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserDto updateUser(UserDto userReq, ModelMap model) {
		if (isUserUpdated(userReq, model))
			return findById(userReq.getId());
		else
			return new UserDto();
	}

	public boolean isUserUpdated(UserDto userReq, ModelMap model) {
		UserDto user = new UserDto();
		try (Connection connection = con.getConnection()) {
			String query = "update users set firstName=?,lastName=?,email=?,password=?,age=?,contact=? where id = ?";
			PreparedStatement st = connection.prepareStatement(query);
			st.setString(1, userReq.getFirstName());
			st.setString(2, userReq.getLastName());
			st.setString(3, userReq.getEmail());
			st.setString(4, userReq.getPassword());
			st.setInt(5, userReq.getAge());
			st.setString(6, userReq.getContact());
			st.setInt(7, userReq.getId());
			int rs = st.executeUpdate();
			return rs != 0;
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error", e.getMessage());
		}
		return false;
	}
}
