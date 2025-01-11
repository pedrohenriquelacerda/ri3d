package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public class GenericSubsystem extends SubsystemBase {
    private VictorSPX motorLeft;
    private VictorSPX motorRight;

    // Shuffleboard variables for motor speed controls
    private GenericEntry leftMotorSpeedWidget;
    private GenericEntry rightMotorSpeedWidget;

    public GenericSubsystem() {
        // Inicializando os motores
        motorLeft = new VictorSPX(6);  
        motorRight = new VictorSPX(7);  

        // Inicializando o Shuffleboard
        ShuffleboardTab tab = Shuffleboard.getTab("Motor Control");

        // Criando entradas no Shuffleboard para controlar a velocidade dos motores
        leftMotorSpeedWidget = tab.add("Left Motor Speed", 0.0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withPosition(0, 0)
            .withSize(2, 1)
            .getEntry(); // Use getEntry() to get the data entry for the slider

        rightMotorSpeedWidget = tab.add("Right Motor Speed", 0.0)
            .withWidget(BuiltInWidgets.kNumberSlider)
            .withPosition(0, 1)
            .withSize(2, 1)
            .getEntry();
    }

    public void updateMotorSpeeds() {
        // Obtém a velocidade do motor esquerdo
        double leftSpeed = leftMotorSpeedWidget.getDouble(0.0);
        
        // Obtém a velocidade do motor direito
        double rightSpeed = rightMotorSpeedWidget.getDouble(0.0);

        // Define a velocidade dos motores de acordo com os valores do Shuffleboard
        motorLeft.set(VictorSPXControlMode.Velocity, leftSpeed);
        motorRight.set(VictorSPXControlMode.Velocity, rightSpeed);  
    }

    @Override
    public void periodic() {
        this.updateMotorSpeeds();
    }
}
