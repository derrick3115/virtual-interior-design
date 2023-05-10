package com.derrick.services.DesignServiceImp;

import com.derrick.dao.userAuthentication;
import com.derrick.model.Signup;
import com.derrick.repository.SignupRepository;
import com.derrick.services.SignupInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupImp implements SignupInterface {
  userAuthentication dao=new userAuthentication();
    @Autowired
    SignupRepository signupRepository;

    public SignupImp() {
    }

    @Override
    public Signup saveAccount(Signup signup) {
        return signupRepository.save(signup);
    }

    @Override
    public Signup findAccount(String password) {
        return signupRepository.findById(password).get();
    }

    @Override
    public boolean userCheck(String email, String password) {

        return dao.loginUser(email, password);
    }
}
