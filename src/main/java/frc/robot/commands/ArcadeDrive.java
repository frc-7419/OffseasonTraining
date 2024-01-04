package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ArcadeDrive extends CommandBase {

    private final DriveBaseSubsystem driveBaseSubsystem;
    private final XboxController controller;

    public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController controller) {
        this.driveBaseSubsystem = driveBaseSubsystem;
        this.controller = controller;
        addRequirements(driveBaseSubsystem);
    }

    @Override
    public void execute() {
        double forward = -controller.getLeftY();
        double rotation = controller.getRightX();
        forward *= 0.5;
        rotation *= 0.5;

        driveBaseSubsystem.setPower(forward + rotation, forward - rotation);
    }

    @Override
    public void end(boolean interrupted) {
        driveBaseSubsystem.setPower(0, 0);
    }
}
