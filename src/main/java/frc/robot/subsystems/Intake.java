package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private WPI_TalonSRX intake;
    public Intake() {
        this.intake = new WPI_TalonSRX(7);
    }

    public void setMotor(double powerMotor) {
    this.intake.set(powerMotor);
}
    public void stopMotor() {
    this.intake.set(0);
}
}
