package com.assigenment.passwordgen.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigenment.passwordgen.Model.user;
import com.assigenment.passwordgen.Repository.userepo;

import java.util.List;

@Service
public class userservice {

    @Autowired
    private userepo userRepository;

    // Create a new user
    public user createUser(String firstName, String middleName, String lastName) {
        String password = generatePassword(firstName, middleName, lastName);
        user user = new user();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setPassword(password);

        return userRepository.save(user);
    }

    // Get all users
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    // Generate a password for the user
    private String generatePassword(String firstName, String middleName, String lastName) {
        String firstPart = getInitials(firstName) + getInitials(middleName) + getInitials(lastName);
        int randomNumber = (int) (Math.random() * 900) + 100; // Generate 3-digit random number
        return firstPart + randomNumber;
    }

    // Helper method to get initials from a name
    private String getInitials(String name) {
        return name.length() >= 2 ? name.substring(0, 2) : name + "X";
    }
}
