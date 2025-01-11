package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
    private TalonSRX motor;

    public Climber() {
        this.motor = new TalonSRX(8);

        this.motor.setInverted(false);

        this.motor.setNeutralMode(NeutralMode.Brake);
    }

    public void setMotor(double percentOutput) {
        this.motor.set(TalonSRXControlMode.PercentOutput, percentOutput);
    }

    public void stopMotor() {
        this.motor.set(TalonSRXControlMode.PercentOutput, 0);
    }
}
