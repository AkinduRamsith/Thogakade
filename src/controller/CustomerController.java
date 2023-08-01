package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class CustomerController extends Component {
    public TextField txtId;
    public TextField txtSalary;
    public TextField txtName;
    public TextField txtAddress;

    public AnchorPane anpUpdateCustomerForm;
    public AnchorPane anpAddCustomerForm;
    public AnchorPane anpDashBoard;
    public AnchorPane anpCustomer;
    public TextField txtCustomerUpdateName;
    public TextField txtCustomerUpdateId;
    public TextField txtCustomerUpdateAddress;
    public TextField txtCustomerUpdateSalary;
    public TextField txtCustomerUpdateSearch;


    public void btnCancelOnAction(ActionEvent actionEvent) {
        anpDashBoard.setVisible(true);
        anpCustomer.setVisible(false);
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");
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




    public void btnAddCustomerOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Customer Add");
            alert.setHeaderText(null);
            alert.setContentText("Added Success");

            alert.showAndWait();

        }else{
            System.out.println("Fail");
        }


        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");
    }

    public void btnViewCustomerFormOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteCustomerFormOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchCustomerFormOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateCustomerFormOnAction(ActionEvent actionEvent) {
        anpAddCustomerForm.setVisible(false);
        anpUpdateCustomerForm.setVisible(true);
    }

    public void btnAddCustomerFormOnAction(ActionEvent actionEvent) {
        anpAddCustomerForm.setVisible(true);
        anpUpdateCustomerForm.setVisible(false);

    }

    public void btnCustomerOnAction(ActionEvent actionEvent) {
        anpCustomer.setVisible(true);
        anpDashBoard.setVisible(false);
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnItemOnAction(ActionEvent actionEvent) {
    }

    public void btnBackCustomer(ActionEvent actionEvent) {
        anpDashBoard.setVisible(true);
        anpCustomer.setVisible(false);
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");



        txtCustomerUpdateSearch.setText("");
        txtCustomerUpdateId.setText("");
        txtCustomerUpdateName.setText("");
        txtCustomerUpdateAddress.setText("");
        txtCustomerUpdateSalary.setText("");

    }

    public void txtCustomerUpdateSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        String SQL="Select * From Customer where id='"+txtCustomerUpdateSearch.getText()+"'";
        ResultSet rst = stm.executeQuery(SQL);
        if(rst.next()){
            txtCustomerUpdateId.setText(rst.getString("id"));
            txtCustomerUpdateName.setText(rst.getString("name"));
            txtCustomerUpdateAddress.setText(rst.getString("address"));
            txtCustomerUpdateSalary.setText(String.valueOf(rst.getDouble("salary")));
        }
    }

    public void btnCustomerUpdateSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtCustomerUpdateSearchOnAction(actionEvent);
    }

    public void btnCustomerUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id=txtCustomerUpdateId.getText();
        String name=txtCustomerUpdateName.getText();
        String address=txtCustomerUpdateAddress.getText();
        double salary= Double.parseDouble(txtCustomerUpdateSalary.getText());
        Customer customer=new Customer(id,name,address,salary);
        String SQL="Update Customer set name=?,address=?,salary=? where id=?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(SQL);
        pstm.setObject(1,name);
        pstm.setObject(2,address);
        pstm.setObject(3,salary);
        pstm.setObject(4,id);
        int i = pstm.executeUpdate();
        if (i>0){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Success");
            alert.setHeaderText(null);
            alert.setContentText("Update Success");
            alert.showAndWait();


            txtCustomerUpdateSearch.setText("");
            txtCustomerUpdateId.setText("");
            txtCustomerUpdateName.setText("");
            txtCustomerUpdateAddress.setText("");
            txtCustomerUpdateSalary.setText("");
        }
    }

    public void btnCustomerUpdateCancelOnAction(ActionEvent actionEvent) {
        anpDashBoard.setVisible(true);
        anpCustomer.setVisible(false);
        txtCustomerUpdateSearch.setText("");
        txtCustomerUpdateId.setText("");
        txtCustomerUpdateName.setText("");
        txtCustomerUpdateAddress.setText("");
        txtCustomerUpdateSalary.setText("");
    }
}
