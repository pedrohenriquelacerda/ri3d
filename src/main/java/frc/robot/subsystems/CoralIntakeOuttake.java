package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CoralIntakeOuttake extends SubsystemBase {
    private VictorSPX motorUpper;
    private TalonSRX motorLower;

    public CoralIntakeOuttake() {
        this.motorUpper = new VictorSPX(5);
        this.motorLower = new TalonSRX(20);

        this.motorUpper.setInverted(true);
        this.motorLower.setInverted(true);

        this.motorUpper.setNeutralMode(NeutralMode.Coast);
        this.motorLower.setNeutralMode(NeutralMode.Coast);
    }

    public void setMotors(double percentOutput) {
        this.motorUpper.set(VictorSPXControlMode.PercentOutput, percentOutput);
        this.motorLower.set(TalonSRXControlMode.PercentOutput, percentOutput);
    }

    public void stopMotors() {
        this.motorUpper.set(VictorSPXControlMode.Velocity, 0);
        this.motorLower.set(TalonSRXControlMode.PercentOutput, 0);
    }
}
