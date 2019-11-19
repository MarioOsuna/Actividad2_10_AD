/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Act2_10;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class Act2_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "root", "usuario");

            String EMP_NO = "1111";
            String APELLIDO = "Osuna";
            String OFICIO = "EMPLEADO";
            String DIR = "";
            String SALARIO = "2500";
            String COMISION = "";
            String DEPT_NO = "15";
                   
            int contador = 0;
               
            String select = String.format("SELECT dept_no FROM departamentos WHERE dept_no=%s", DEPT_NO);

            Statement sentencia1 = conexion.createStatement();

            boolean res = sentencia1.execute(select);

            if (res) {

                contador++;
            } else {
                System.out.println("NO EXISTE EL DEPARTAMENTO");
            }
            sentencia1.close();

            String select1 = String.format("SELECT emp_no FROM empleados WHERE emp_no=%s", EMP_NO);
            Statement sentencia2 = conexion.createStatement();

            boolean res1 = sentencia2.execute(select1);
            System.out.println(sentencia2.execute(select1));
            if (!res1) {
                contador++;

                // System.out.println(select1);
            } else {
                System.out.println("YA EXISTE ESE NÚMERO DE EMPLEADO");

            }

            sentencia2.close();

            if (contador == 6) {
                String insert = String.format("INSERT INTO empleados VALUE (%s, '%s', '%s',%s,'%s',%s,%s,%s)", EMP_NO, APELLIDO, OFICIO, DIR,fecha_actual(), SALARIO, COMISION, DEPT_NO);
                //System.out.printf("Filas afectadas: %d %n", filas);
            }

            conexion.close();
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String fecha_actual() {

        String FECHA_ACT = "";

        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del a?o, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int a?o = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);

        FECHA_ACT = a?o + "-" + (mes + 1) + "-" + dia;

        return FECHA_ACT;
    }

}
