package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Customer;
import model.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController extends Component implements Initializable {
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
    public TextField txtSearchId;
    public TextField txtSearchName;
    public TextField txtSearchAddress;
    public TextField txtSearchSalary;
    public TextField txtSearch;
    public AnchorPane anpSearchCustomerForm;
    public TextField txtDeleteSearch;
    public TextField txtDeleteId;
    public TextField txtDeleteName;
    public TextField txtDeleteAddress;
    public TextField txtDeletedSalary;
    public AnchorPane anpDeleteCustomerForm;
    public AnchorPane anpViewCustomerForm;
    public AnchorPane anpItemAddForm;
    public TextField txtItemDescription;
    public TextField txtItemCode;
    public TextField txtItemUnitPrice;
    public TextField txtItemQtyOnHand;
    public AnchorPane anpItem;
    public AnchorPane anpItemUpdateForm;
    public AnchorPane anpSearchItemForm;
    public AnchorPane anpItemDeleteForm;
    public AnchorPane anpViewItemForm;

    @FXML
    private TableColumn<Customer, String> colCustomerAddress;

    @FXML
    private TableColumn<Customer, String> colCustomerId;

    @FXML
    private TableColumn<Customer, String> colCustomerName;

    @FXML
    private TableColumn<Customer, Double> colCustomerSalary;

    @FXML
    private TableView<Customer> tblViewCustomer;

    ObservableList<Customer> list = FXCollections.observableArrayList();


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
        pstm.setObject(1, customer.getId());
        pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, customer.getSalary());
        int i = pstm.executeUpdate();
        if (i > 0) {
            System.out.println("Added Success");

        } else {
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
        pstm.setObject(1, customer.getId());
        pstm.setObject(2, customer.getName());
        pstm.setObject(3, customer.getAddress());
        pstm.setObject(4, customer.getSalary());
        int i = pstm.executeUpdate();
        if (i > 0) {
            System.out.println("Added Success");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Customer Add");
            alert.setHeaderText(null);
            alert.setContentText("Added Success");

            alert.showAndWait();

        } else {
            System.out.println("Fail");
        }


        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtSalary.setText("");
    }

    public void btnViewCustomerFormOnAction(ActionEvent actionEvent) {
        anpViewCustomerForm.setVisible(true);
        anpDeleteCustomerForm.setVisible(false);
        anpSearchCustomerForm.setVisible(false);
        anpUpdateCustomerForm.setVisible(false);
        anpAddCustomerForm.setVisible(false);
    }

    public void btnDeleteCustomerFormOnAction(ActionEvent actionEvent) {
        anpDeleteCustomerForm.setVisible(true);
        anpSearchCustomerForm.setVisible(false);
        anpUpdateCustomerForm.setVisible(false);
        anpAddCustomerForm.setVisible(false);
        anpViewCustomerForm.setVisible(false);
    }

    public void btnSearchCustomerFormOnAction(ActionEvent actionEvent) {
        anpSearchCustomerForm.setVisible(true);
        anpUpdateCustomerForm.setVisible(false);
        anpAddCustomerForm.setVisible(false);
        anpDeleteCustomerForm.setVisible(false);
        anpViewCustomerForm.setVisible(false);
    }

    public void btnUpdateCustomerFormOnAction(ActionEvent actionEvent) {
        anpAddCustomerForm.setVisible(false);
        anpSearchCustomerForm.setVisible(false);
        anpUpdateCustomerForm.setVisible(true);
        anpDeleteCustomerForm.setVisible(false);
        anpViewCustomerForm.setVisible(false);
    }

    public void btnAddCustomerFormOnAction(ActionEvent actionEvent) {
        anpAddCustomerForm.setVisible(true);
        anpUpdateCustomerForm.setVisible(false);
        anpSearchCustomerForm.setVisible(false);
        anpDeleteCustomerForm.setVisible(false);
        anpViewCustomerForm.setVisible(false);

    }

    public void btnCustomerOnAction(ActionEvent actionEvent) {
        anpCustomer.setVisible(true);
        anpDashBoard.setVisible(false);
    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnItemOnAction(ActionEvent actionEvent) {
        anpItem.setVisible(true);
        anpDashBoard.setVisible(false);
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


        txtSearch.setText("");
        txtSearchId.setText("");
        txtSearchName.setText("");
        txtSearchAddress.setText("");
        txtSearchSalary.setText("");


        txtDeleteSearch.setText("");
        txtDeleteId.setText("");
        txtDeleteName.setText("");
        txtDeleteAddress.setText("");
        txtDeletedSalary.setText("");

    }

    public void txtCustomerUpdateSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        String SQL = "Select * From Customer where id='" + txtCustomerUpdateSearch.getText() + "'";
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
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
        String id = txtCustomerUpdateId.getText();
        String name = txtCustomerUpdateName.getText();
        String address = txtCustomerUpdateAddress.getText();
        double salary = Double.parseDouble(txtCustomerUpdateSalary.getText());
        Customer customer = new Customer(id, name, address, salary);
        String SQL = "Update Customer set name=?,address=?,salary=? where id=?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(SQL);
        pstm.setObject(1, name);
        pstm.setObject(2, address);
        pstm.setObject(3, salary);
        pstm.setObject(4, id);
        int i = pstm.executeUpdate();
        if (i > 0) {

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


    public void btnSearchCancelOnActon(ActionEvent actionEvent) {
        anpDashBoard.setVisible(true);
        anpCustomer.setVisible(false);
        txtSearch.setText("");
        txtSearchId.setText("");
        txtSearchName.setText("");
        txtSearchAddress.setText("");
        txtSearchSalary.setText("");

    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtSearchOnAction(actionEvent);
    }

    public void txtSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        String SQL = "Select * From Customer where id='" + txtSearch.getText() + "'";
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            txtSearchId.setText(rst.getString("id"));
            txtSearchName.setText(rst.getString("name"));
            txtSearchAddress.setText(rst.getString("address"));
            txtSearchSalary.setText(String.valueOf(rst.getDouble("salary")));
        } else {
            txtSearch.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Searching");
            alert.setHeaderText(null);
            alert.setContentText("Customer not Found");
            alert.showAndWait();
        }

    }

    public void txtDeleteSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        String SQL = "Select * From Customer where id='" + txtDeleteSearch.getText() + "'";
        ResultSet rst = stm.executeQuery(SQL);
        if (rst.next()) {
            txtDeleteId.setText(rst.getString("id"));
            txtDeleteName.setText(rst.getString("name"));
            txtDeleteAddress.setText(rst.getString("address"));
            txtDeletedSalary.setText(String.valueOf(rst.getDouble("salary")));
        } else {
            txtDeleteSearch.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Searching");
            alert.setHeaderText(null);
            alert.setContentText("Customer not Found");
            alert.showAndWait();
        }

    }

    public void btnDeleteSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        txtDeleteSearchOnAction(actionEvent);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtDeleteSearch.getText();
        String SQL = "Delete From Customer where id='" + id + "'";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        int i = stm.executeUpdate(SQL);
        if (i > 0) {
            System.out.println(i);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deleting");
            alert.setHeaderText(null);
            alert.setContentText("Delete Success");
            alert.showAndWait();

            txtDeleteSearch.setText("");
            txtDeleteId.setText("");
            txtDeleteName.setText("");
            txtDeleteAddress.setText("");
            txtDeletedSalary.setText("");
        }

    }

    public void btnDeleteCancelOnAction(ActionEvent actionEvent) {
        anpCustomer.setVisible(false);
        anpDashBoard.setVisible(true);
        txtDeleteSearch.setText("");
        txtDeleteId.setText("");
        txtDeleteName.setText("");
        txtDeleteAddress.setText("");
        txtDeletedSalary.setText("");
    }

    public void btnViewCustomerReloadOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        list.clear();
        String SQL = "Select * From Customer";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(SQL);
        ResultSet rst = pstm.executeQuery();

        while (rst.next()) {
            Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
            list.add(customer);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        colCustomerAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        colCustomerSalary.setCellValueFactory(new PropertyValueFactory<Customer, Double>("salary"));
        tblViewCustomer.setItems(list);
    }

    public void btnAddItemFormOnAction(ActionEvent actionEvent) {
        anpItem.setVisible(false);
        anpItemAddForm.setVisible(true);
        anpItemUpdateForm.setVisible(false);
        anpSearchItemForm.setVisible(false);
        anpItemDeleteForm.setVisible(false);
        anpViewItemForm.setVisible(false);

    }

    public void btnAddItemOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String code = txtItemCode.getText();
        String description = txtItemDescription.getText();
        double unitPrice = Double.parseDouble(txtItemUnitPrice.getText());
        int qtyOnHand = Integer.parseInt(txtItemQtyOnHand.getText());
        System.out.println(code + "," + description + "," + unitPrice + "," + qtyOnHand);
        Item item = new Item(code, description, unitPrice, qtyOnHand);
        String SQL = "Insert into Item Values(?,?,?,?)";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(SQL);
        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getUnitPrice());
        pstm.setObject(4, item.getQtyOnHand());
        int i = pstm.executeUpdate();
        if (i > 0) {
            System.out.println("Added Success");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Item Add");
            alert.setHeaderText(null);
            alert.setContentText("Added Success");

            alert.showAndWait();

        } else {
            System.out.println("Fail");
        }


        txtItemCode.setText("");
        txtItemDescription.setText("");
        txtItemUnitPrice.setText("");
        txtItemQtyOnHand.setText("");
    }

    public void btnItemCancelOnAction(ActionEvent actionEvent) {
        anpDashBoard.setVisible(true);
        anpItem.setVisible(false);
        txtItemCode.setText("");
        txtItemDescription.setText("");
        txtItemUnitPrice.setText("");
        txtItemQtyOnHand.setText("");
    }

    public void btnUpdateItemFormOnAction(ActionEvent actionEvent) {
    }

    public void btnSearchItemFormOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteItemFormOnAction(ActionEvent actionEvent) {
    }

    public void btnViewItemFormOnAction(ActionEvent actionEvent) {
    }

    public void btnBackItem(ActionEvent actionEvent) {
        anpItemAddForm.setVisible(false);
        anpItemDeleteForm.setVisible(false);
        anpSearchItemForm.setVisible(false);
        anpItemUpdateForm.setVisible(false);
        anpViewItemForm.setVisible(false);
        anpDashBoard.setVisible(true);


        anpItem.setVisible(false);
        txtItemCode.setText("");
        txtItemDescription.setText("");
        txtItemUnitPrice.setText("");
        txtItemQtyOnHand.setText("");
    }

    public void txtItemUpdateSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnItemUpdateSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnItemUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnItemUpdateCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnItemSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnItemSearchCancelOnAction(ActionEvent actionEvent) {
    }

    public void txtItemSearchOnAction(ActionEvent actionEvent) {
    }

    public void txtItemDeleteSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnItemDeleteSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnItemDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnItemDeleteCancelOnAction(ActionEvent actionEvent) {
    }

    public void btnViewItemReloadOnAction(ActionEvent actionEvent) {
    }
}
