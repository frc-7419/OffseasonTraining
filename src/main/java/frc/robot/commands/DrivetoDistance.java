// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DistanceSensorSubsystem;
import frc.robot.subsystems.DriveBaseSubsystem;

public class DrivetoDistance extends CommandBase {

    DriveBaseSubsystem driveBaseSubsystem;
    DistanceSensorSubsystem distanceSensorSubsystem;
    float target;
    public DrivetoDistance(DriveBaseSubsystem driveBaseSubsystem, AnalogPotentiometer analogPotentiometer) {
      this.driveBaseSubsystem = driveBaseSubsystem;
      distanceSensorSubsystem = new DistanceSensorSubsystem(analogPotentiometer);
      addRequirements(driveBaseSubsystem);
    }
  
    @Override
    public void initialize() {
      target = 0.09f;
    }


    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double setPower = distanceSensorSubsystem.getDistance();
        if (setPower > target) {
            driveBaseSubsystem.setLeftRightPower(5 * setPower, 5 * setPower);
        }
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
      return false;
    }
  
}