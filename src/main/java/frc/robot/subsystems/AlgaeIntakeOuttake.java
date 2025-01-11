package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AlgaeIntakeOuttake extends SubsystemBase {
    private TalonSRX motor;

    public AlgaeIntakeOuttake() {
        this.motor = new TalonSRX(9);

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
