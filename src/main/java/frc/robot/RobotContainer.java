package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.DriveBaseSubsystem;

public class RobotContainer {
  
  //init your joysticks
  XboxController joystickController = new XboxController(0);
  

  // init your subsystems
  DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();



  // innit your commands
  ArcadeDrive arcadeDrive = new ArcadeDrive(driveBaseSubsystem, joystickController);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
  
  public void setDefaultCommands() {

    driveBaseSubsystem.setDefaultCommand(arcadeDrive);
    
  }
}
