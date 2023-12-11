// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;

public class DrivetoDistance extends CommandBase {
  /** Creates a new DriveToDistance. */
  private DriveBaseSubsystem driveBaseSubsystem;
  private ProfiledPIDController pid = new ProfiledPIDController(-0.001, 0, 0, new TrapezoidProfile.Constraints(0.5, 1));
  private MedianFilter m_filter = new MedianFilter(5);
  private double target;
  private double tolerance = 1;
  
  public DrivetoDistance(DriveBaseSubsystem driveBaseSubsystem) {
    this.driveBaseSubsystem = driveBaseSubsystem;
    addRequirements(driveBaseSubsystem);
  }

  
  @Override
  public void initialize() {
    driveBaseSubsystem.coast();
    target = 30;
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double distance = driveBaseSubsystem.getUltrasonicDistance();
    double filtered = m_filter.calculate(distance);
    // drivebaseSubsystem.setAll(pid.calculate(filtered, target));
    System.out.println(pid.calculate(filtered, target));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBaseSubsystem.setLeftRightPower(0, 0);
    driveBaseSubsystem.brake();
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(target - driveBaseSubsystem.getUltrasonicDistance()) <= tolerance) {
      return true;
    }
    return false;
  }
  
}