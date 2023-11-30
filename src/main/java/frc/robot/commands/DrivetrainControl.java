// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivebaseSubsystem;
import java.lang.Math;

public class DrivetrainControl extends CommandBase {
  /** Creates a new DrivetrainControl. */

  DrivebaseSubsystem drivebaseSubsystem;
  XboxController xboxController;

  public DrivetrainControl(DrivebaseSubsystem drivebaseSubsystem, XboxController xboxController) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivebaseSubsystem = drivebaseSubsystem;
    this.xboxController = xboxController;
    addRequirements(drivebaseSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivebaseSubsystem.coast();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double multiplier;
    if(xboxController.getLeftBumperPressed()){
      multiplier = 0.3;
    }
    else{
      multiplier = 1;
    }
    double lX = xboxController.getLeftX()*multiplier;
    double lY = xboxController.getLeftY()*multiplier;
    double maximum = Math.max(Math.abs(lX), Math.abs(lY));
    double total = lX + lY;
    double difference = lX - lY;

    if (lX >= 0) {
      if (lY >= 0) {
        drivebaseSubsystem.setLeftPower(maximum);
        drivebaseSubsystem.setRightPower(difference);
      } else {
        drivebaseSubsystem.setLeftPower(total);
        drivebaseSubsystem.setRightPower(maximum);
      }
    } else {
      if (lY >= 0) {
        drivebaseSubsystem.setLeftPower(total);
        drivebaseSubsystem.setRightPower(-maximum);
      } else {
        drivebaseSubsystem.setLeftPower(-maximum);
        drivebaseSubsystem.setRightPower(difference);
      }
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivebaseSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
