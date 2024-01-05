// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DistanceSensorSubsystem;
import frc.robot.subsystems.DriveBaseSubsystem;

public class DriveWithPID extends CommandBase {
  /** Creates a new DriveWithPID. */
  private DriveBaseSubsystem driveBaseSubsystem;
  private DistanceSensorSubsystem distanceSensorSubsystem;
  private PIDController pidController;
  private double setpoint = 5;
  public DriveWithPID(DriveBaseSubsystem driveBaseSubsystem, DistanceSensorSubsystem distanceSensorSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveBaseSubsystem = driveBaseSubsystem;
    this.distanceSensorSubsystem = distanceSensorSubsystem;
    pidController = new PIDController(0.5, 0, 0);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveBaseSubsystem.coast();
    pidController.setTolerance(0.1);
    pidController.setSetpoint(setpoint);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double distance = distanceSensorSubsystem.getDistance();
    double power = pidController.calculate(distance);
    driveBaseSubsystem.setAllPower(power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveBaseSubsystem.setAllPower(0);
    driveBaseSubsystem.brake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidController.atSetpoint();
  }
}
