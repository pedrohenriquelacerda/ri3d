package frc.robot.buttonBindings;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.core.util.oi.SmartController;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.constants.ControllerConstants;
import frc.robot.constants.DrivetrainConstants;
import frc.robot.subsystems.AlgaeIntakeOuttake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.CoralIntakeOuttake;
//import frc.robot.subsystems.DriveNeoTest;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakeJoint;
import frc.robot.subsystems.Lift;

public class DriverButtonBindings {

  private final Drivetrain drivetrain;
  private final Lift lift;
  private final Climber climber;
  private final CoralIntakeOuttake coralIntakeOuttake;
  private final AlgaeIntakeOuttake algaeIntakeOuttake;
  private final IntakeJoint intakeJoint;

  public static SmartController driver;

  public DriverButtonBindings(Drivetrain drivetrain, Lift lift, 
                              Climber climber, CoralIntakeOuttake coralIntakeOuttake, 
                              AlgaeIntakeOuttake algaeIntakeOuttake, IntakeJoint intakeJoint) {

    this.drivetrain = drivetrain;
    this.lift = lift;
    this.climber = climber;
    this.coralIntakeOuttake = coralIntakeOuttake;
    this.algaeIntakeOuttake = algaeIntakeOuttake;
    this.intakeJoint = intakeJoint;

    this.driver = new SmartController(ControllerConstants.kDriverControllerPort);

    this.buttonBindingsDrivetain();
    this.buttonBindingsLift();
    this.buttonBindingsClimber();
    this.buttonBindingsCoralIntakeOuttake();
    this.buttonBindingsSysId();
  }

  public void buttonBindingsDrivetain() {
    this.drivetrain.setDefaultCommand(
        new ArcadeDrive(
            this.drivetrain,
            () -> driver.getLeftY(),
            () -> driver.getRightX(),
            driver));
  }

  public void buttonBindingsLift() {
    // Lift Up
    this.driver.whileXRight(Commands.startEnd(() -> lift.setMotor(0.4), () -> lift.stopMotor(), lift));
    // Lift Down
    this.driver.whileXLeft(Commands.startEnd(() -> lift.setMotor(-0.4), () -> lift.stopMotor(), lift));
  }

  public void buttonBindingsClimber() {
    //Climb Up
    this.driver.whileXUp(Commands.startEnd(() -> climber.setMotor(1), () -> climber.stopMotor(), climber));
    //Climb Down
    this.driver.whileXDown(Commands.startEnd(() -> climber.setMotor(-1), () -> climber.stopMotor(), climber));
  } 

  public void buttonBindingsCoralIntakeOuttake() {
    //Intake
    this.driver.whileAButton(Commands.startEnd(() -> coralIntakeOuttake.setMotors(0.3), () -> coralIntakeOuttake.stopMotors(), coralIntakeOuttake));
    //Outtake
    this.driver.whileBButton(Commands.startEnd(() -> coralIntakeOuttake.setMotors(-0.4), () -> coralIntakeOuttake.stopMotors(), coralIntakeOuttake));

  }

  public void buttonBindingsAlgaeIntakeOuttake() {
    //Intake
    this.driver.whileRightBumper(Commands.startEnd(() -> algaeIntakeOuttake.setMotor(0.7), () -> algaeIntakeOuttake.stopMotor(), algaeIntakeOuttake));
    //Outtake
    this.driver.whileLeftBumper(Commands.startEnd(() -> algaeIntakeOuttake.setMotor(-0.7), () -> algaeIntakeOuttake.stopMotor(), algaeIntakeOuttake));
  }

  public void buttonBindingsSysId() {
    if (DrivetrainConstants.SysId.isSysIdTunning) {
      this.driver.whileAButton(drivetrain.sysIdDynamic(Direction.kReverse));
      this.driver.whileYButton(drivetrain.sysIdDynamic(Direction.kForward));
      this.driver.whileBButton(drivetrain.sysIdQuasistatic(Direction.kForward));
      this.driver.whileXButton(drivetrain.sysIdQuasistatic(Direction.kReverse));
    }
  }

}