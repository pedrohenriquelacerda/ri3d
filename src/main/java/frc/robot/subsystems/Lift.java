package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
    private VictorSPX motorLeft;
    private VictorSPX motorRight;
    

    public Lift() {
        this.motorLeft = new VictorSPX(10);
        this.motorRight = new VictorSPX(11);

        this.motorLeft.setInverted(false);
        this.motorRight.setInverted(true);


        this.motorLeft.setNeutralMode(NeutralMode.Brake);
        this.motorRight.setNeutralMode(NeutralMode.Brake);

    }

    public void setMotor(double percentOutput) {
        this.motorLeft.set(VictorSPXControlMode.PercentOutput, percentOutput);
        this.motorRight.set(VictorSPXControlMode.PercentOutput, percentOutput);
    }

    public void stopMotor() {
        this.motorLeft.set(VictorSPXControlMode.PercentOutput, 0);
        this.motorRight.set(VictorSPXControlMode.PercentOutput, 0);
    }
}
