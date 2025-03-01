package frc.robot.buttonBindings;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.core.util.oi.SmartController;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.constants.ControllerConstants;
import frc.robot.constants.DrivetrainConstants;
//import frc.robot.subsystems.DriveNeoTest;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class DriverButtonBindings {

  private final Drivetrain drivetrain;
  private final Intake intake;
  private final Shooter shooter;

  public static SmartController driver;

  public DriverButtonBindings(Drivetrain drivetrain, Intake intake, Shooter shooter) {

    this.drivetrain = drivetrain;
    this.intake = intake;
    this.shooter = shooter;
    
    this.driver = new SmartController(ControllerConstants.kDriverControllerPort);

    this.buttonBindingsDrivetain();
    buttonBindingsShooter();
    buttonBindingsIntake();
        //this.buttonBindingsSysId();
  }

  public void buttonBindingsDrivetain() {
    this.drivetrain.setDefaultCommand(
        new ArcadeDrive(
            this.drivetrain,
            () -> driver.getLeftY(),
            () -> driver.getRightX(),
            driver));
          
  }
  public void buttonBindingsIntake() {
    this.driver.whileLeftBumper(Commands.startEnd(() -> intake.setMotor(0.8
    ), () -> intake.stopMotor(), intake));
    this.driver.whileAButton(Commands.startEnd(() -> intake.setMotor(-0.6), () -> intake.stopMotor(), intake));
  ;
  }
  public void buttonBindingsShooter() {
    this.driver.whileRightBumper(Commands.startEnd(() -> shooter.setMotor(0.85), () -> shooter.stopMotor(), shooter));
  }

  public void buttonBindingsSysId() {
    if (DrivetrainConstants.SysId.isSysIdTunning) {
      //this.driver.whileAButton(drivetrain.sysIdDynamic(Direction.kReverse));
      //this.driver.whileYButton(drivetrain.sysIdDynamic(Direction.kForward));
      //this.driver.whileBButton(drivetrain.sysIdQuasistatic(Direction.kForward));
      //this.driver.whileXButton(drivetrain.sysIdQuasistatic(Direction.kReverse));
    }
  }


}