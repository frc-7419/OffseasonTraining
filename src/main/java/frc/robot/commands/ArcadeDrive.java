package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;
import edu.wpi.first.wpilibj.XboxController;

public class ArcadeDrive extends CommandBase {
  private DriveBaseSubsystem driveBaseSubsystem;
  private XboxController controller;
  // private DistanceSensorSubsystem distanceSensorSubsystem;

  public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController controller) {
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.controller = controller;
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

    double X = controller.getLeftX()*0.3;
    double Y = controller.getLeftY()*0.3;

    double maximum = Math.max(Math.abs(X), Math.abs(Y));
    double total = X + Y;
    double difference = X - Y;
    
    if (X >= 0 && Y >= 0) {
      driveBaseSubsystem.setLeftRightPower(maximum, difference);
    } else if (X >= 0) {
      driveBaseSubsystem.setLeftRightPower(total, maximum);
    } else if (Y >= 0) {
      driveBaseSubsystem.setLeftRightPower(total, -maximum);
    } else {
      driveBaseSubsystem.setLeftRightPower(-maximum, difference);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBaseSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
