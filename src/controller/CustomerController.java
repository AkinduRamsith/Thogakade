package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class CustomerController {
    public TextField txtId;
    public TextField txtSalary;
    public TextField txtName;
    public TextField txtAddress;

    public void btnCancelOnAction(ActionEvent actionEvent) {

    }

    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        System.out.println(id + "," + name + "," + address + "," + salary);
        Customer customer = new Customer(id, name, address, salary);
        String SQL = "Insert into Customer Values(?,?,?,?)";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(SQL);
        pstm.setObject(1,customer.getId());
        pstm.setObject(2,customer.getName());
        pstm.setObject(3,customer.getAddress());
        pstm.setObject(4,customer.getSalary());
        int i = pstm.executeUpdate();
        if(i>0){
            System.out.println("Added Success");

        }else{
            System.out.println("Fail");
        }


        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");


    }
}
