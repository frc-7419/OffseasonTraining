package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ArcadeDrive extends CommandBase {
  private DriveBaseSubsystem driveBaseSubsystem;
  private XboxController driverController;
  private double driveCoefficient = 0.5;

  public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController driverController) {
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.driverController = driverController;
    addRequirements(driveBaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveBaseSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double forwardPower = driverController.getLeftY();
    double turnPower = driverController.getRightX();
    double leftPower = forwardPower - turnPower;
    double rightPower = forwardPower + turnPower;
    driveBaseSubsystem.setLeftPower(leftPower * driveCoefficient);
    driveBaseSubsystem.setRightPower(rightPower * driveCoefficient);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
