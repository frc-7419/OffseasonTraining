package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DistanceSensorSubsystem;

public class ArcadeDrive extends CommandBase {
  private DriveBaseSubsystem driveBaseSubsystem;
  private XboxController controller;
  private DistanceSensorSubsystem distanceSensorSubsystem;

  public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController controller, DistanceSensorSubsystem distanceSensorSubsystem) {
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.controller = controller;
    this.distanceSensorSubsystem = distanceSensorSubsystem;
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
    double powerX = controller.getRightX() * 0.3;
    double powerY = controller.getLeftY() * 0.3;
    if (Math.abs(controller.getRightX()) > 0.01) {
      driveBaseSubsystem.setPower(powerX, -powerX);
    }
    if (Math.abs(controller.getLeftY()) > 0.01) {
      driveBaseSubsystem.setPower(powerY, powerY);
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
