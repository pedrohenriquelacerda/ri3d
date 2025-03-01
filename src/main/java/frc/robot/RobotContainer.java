package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.core.util.TrajectoryBuilder;
import frc.robot.buttonBindings.DriverButtonBindings;
import frc.robot.buttonBindings.OperatorButtonBindings;
import frc.robot.commands.autonomous.AutoTeste;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  private final Drivetrain drivetrain;
  private final Intake intake;
  private final Shooter shooter;
  
  //private final GenericSubsystem genericSubsystem;

  public TrajectoryBuilder trajectoryBuilder;
  public DriverButtonBindings driver;
  public OperatorButtonBindings operator;


  public RobotContainer() {
    this.drivetrain = new Drivetrain();
    //this.genericSubsystem = new GenericSubsystem();

    this.intake = new Intake();
    this.shooter = new Shooter();

    this.driver = new DriverButtonBindings(this.drivetrain, this.intake, this.shooter);
    this.operator = new OperatorButtonBindings(this.drivetrain);


    configureButtonBindings();

    this.trajectoryBuilder = new TrajectoryBuilder(drivetrain,
        "1-forward",
        "1-reverse"
        );
  }

  private void configureButtonBindings() {
    this.driver.buttonBindingsDrivetain();
    // this.driver.buttonBindingsSysId();
  }

  public Command getAutonomousCommand() {
    return new AutoTeste(drivetrain, trajectoryBuilder);
  }
}
