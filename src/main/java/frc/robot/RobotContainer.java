package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.core.util.TrajectoryBuilder;
import frc.robot.buttonBindings.DriverButtonBindings;
import frc.robot.buttonBindings.OperatorButtonBindings;
import frc.robot.commands.autonomous.AutoTeste;
import frc.robot.subsystems.AlgaeIntakeOuttake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.CoralIntakeOuttake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.GenericSubsystem;
import frc.robot.subsystems.IntakeJoint;
import frc.robot.subsystems.Lift;

public class RobotContainer {
  private final Drivetrain drivetrain;
  private final Lift lift;
  private final IntakeJoint intakeJoint;
  private final CoralIntakeOuttake coralIntakeOuttake;
  private final AlgaeIntakeOuttake algaeIntakeOuttake;
  private final Climber climber;
  //private final GenericSubsystem genericSubsystem;

  public TrajectoryBuilder trajectoryBuilder;
  public DriverButtonBindings driver;
  public OperatorButtonBindings operator;


  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    this.lift = new Lift();
    this.algaeIntakeOuttake = new AlgaeIntakeOuttake();
    this.coralIntakeOuttake = new CoralIntakeOuttake();
    this.intakeJoint = new IntakeJoint();
    this.climber = new Climber();
    //this.genericSubsystem = new GenericSubsystem();

    this.driver = new DriverButtonBindings(this.drivetrain, lift, climber, coralIntakeOuttake, algaeIntakeOuttake, intakeJoint);
    this.operator = new OperatorButtonBindings(this.drivetrain);


    configureButtonBindings();

    this.trajectoryBuilder = new TrajectoryBuilder(drivetrain,
        "1-forward",
        "1-reverse"
        );
  }

  private void configureButtonBindings() {
    this.driver.buttonBindingsDrivetain();
    this.driver.buttonBindingsLift();
    this.driver.buttonBindingsClimber();
    this.driver.buttonBindingsCoralIntakeOuttake();
    this.driver.buttonBindingsAlgaeIntakeOuttake();
    // this.driver.buttonBindingsSysId();
  }

  public Command getAutonomousCommand() {
    return new AutoTeste(drivetrain, trajectoryBuilder);
  }
}
