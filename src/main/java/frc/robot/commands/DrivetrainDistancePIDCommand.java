package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DistanceSensorSubsystem;
import frc.robot.subsystems.DriveBaseSubsystem;

public class DrivetrainDistancePIDCommand extends CommandBase {

    private final DistanceSensorSubsystem distanceSensorSubsystem;
    private final DriveBaseSubsystem driveBaseSubsystem;
    private final double targetDistance;

    public DrivetrainDistancePIDCommand(DistanceSensorSubsystem distanceSensorSubsystem,
                                        DriveBaseSubsystem driveBaseSubsystem,
                                        double targetDistance) {
        this.distanceSensorSubsystem = distanceSensorSubsystem;
        this.driveBaseSubsystem = driveBaseSubsystem;
        this.targetDistance = targetDistance;

        addRequirements(distanceSensorSubsystem, driveBaseSubsystem);
    }

    @Override
    public void execute() {
        double powerOutput = distanceSensorSubsystem.getPIDOutput(targetDistance);

        driveBaseSubsystem.setPower(powerOutput, powerOutput);
    }

    @Override
    public void end(boolean interrupted) {
        driveBaseSubsystem.setPower(0, 0);
    }

    @Override
    public boolean isFinished() {
        // Modify this condition based on your specific requirements
        return false;
    }
}
