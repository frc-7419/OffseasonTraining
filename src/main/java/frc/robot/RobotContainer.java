package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DrivetrainDistancePIDCommand;
import frc.robot.subsystems.DistanceSensorSubsystem;
import frc.robot.subsystems.DriveBaseSubsystem;

public class RobotContainer {

    private final XboxController xboxController = new XboxController(0);  

    private final DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
    private final PIDController pidController = new PIDController(1.0, 0.0, 0.0);  // not tuned 

    private final DistanceSensorSubsystem distanceSensorSubsystem =
            new DistanceSensorSubsystem(1, pidController);

    private final ArcadeDrive arcadeDriveCommand = new ArcadeDrive(driveBaseSubsystem, xboxController);
    private final DrivetrainDistancePIDCommand drivetrainDistancePIDCommand =
            new DrivetrainDistancePIDCommand(distanceSensorSubsystem, driveBaseSubsystem, 10.0);

    public RobotContainer() {
        configureButtonBindings();
        setDefaultCommands();
    }

    private void configureButtonBindings() {
        new JoystickButton(xboxController, XboxController.Button.kA.value).onTrue(drivetrainDistancePIDCommand);

    }

    void setDefaultCommands() {
        driveBaseSubsystem.setDefaultCommand(arcadeDriveCommand);

        distanceSensorSubsystem.setDefaultCommand(
                new DrivetrainDistancePIDCommand(distanceSensorSubsystem, driveBaseSubsystem, 10.0));

    }


    public Command getAutonomousCommand() {
      return null;
    }
}
