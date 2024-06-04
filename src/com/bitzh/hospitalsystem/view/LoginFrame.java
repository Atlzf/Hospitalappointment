package com.bitzh.hospitalsystem.view;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        // 创建并设置JFrame的基本属性
        setTitle("医疗预约系统");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // 创建按钮
        JButton userLoginButton = new JButton("用户登录");
        JButton doctorLoginButton = new JButton("医生登录");
        JButton adminLoginButton = new JButton("管理员登陆");

        // 添加按钮到JFrame
        JPanel panel = new JPanel();
        panel.add(userLoginButton);
        panel.add(doctorLoginButton);
        panel.add(adminLoginButton);
        add(panel);

        // 添加按钮的点击事件处理
        userLoginButton.addActionListener(e -> {
            // Open user login frame
        });

        doctorLoginButton.addActionListener(e -> {
            // Open doctor login frame
        });

        adminLoginButton.addActionListener(e -> {
            // Open admin login frame
        });
    }
}