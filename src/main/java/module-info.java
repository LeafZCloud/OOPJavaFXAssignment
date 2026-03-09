module edu.farmingdale.csc325_oopjavafxassignment {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.farmingdale.csc325_oopjavafxassignment to javafx.fxml;
    exports edu.farmingdale.csc325_oopjavafxassignment;
}