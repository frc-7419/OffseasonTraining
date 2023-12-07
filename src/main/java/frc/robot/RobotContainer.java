package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
// import the xbox joystick class
import edu.wpi.first.wpilibj.XboxController;
// import the commands
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.DriveBaseSubsystem;
// import frc.robot.subsystems.DistanceSensorSubsystem;


public class RobotContainer {
  
  //init your joysticks
  private XboxController controller = new XboxController(0);
  
  // init your subsystems
  private DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  // private DistanceSensorSubsystem distanceSensorSubsystem = new DistanceSensorSubsystem();

  // innit your commands
  private ArcadeDrive arcadeDrive = new ArcadeDrive(driveBaseSubsystem, controller);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
  
  public void setDefaultCommands() {
    
  }
}
