package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private TalonFX leftShooter;
    private TalonFX rightShooter;

    public Shooter() {
        this.leftShooter = new TalonFX(5);
        this.rightShooter = new TalonFX(6);

        this.leftShooter.setInverted(true);
        this.rightShooter.setInverted(false);
    };

    public void setMotor(double powerFalcon) {
        this.leftShooter.set(powerFalcon);
        this.rightShooter.set(powerFalcon);
    }

    public void stopMotor() {
        this.leftShooter.set(0);
        this.rightShooter.set(0);
    };
}
