package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import the xbox joystick class
import edu.wpi.first.wpilibj.XboxController;

import com.revrobotics.AnalogInput;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.GenericHID;
// import the commands
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.DriveBaseSubsystem;
import frc.robot.commands.DrivetoDistance;


public class RobotContainer {
  
  //init your joysticks
  private XboxController controller = new XboxController(1);
  
  // init your subsystems
  private DriveBaseSubsystem driveBaseSubsystem = new DriveBaseSubsystem();
  // private DistanceSensorSubsystem distanceSensorSubsystem = new DistanceSensorSubsystem();

  // innit your commands
  private ArcadeDrive arcadeDrive = new ArcadeDrive(driveBaseSubsystem, controller);

  AnalogPotentiometer analogPotentiometer = new AnalogPotentiometer(0, 180, 30);

  public RobotContainer() {
    configureBindings();
    configureButtonBindings();
    setDefaultCommands();
  }

  private void configureButtonBindings() {
    new JoystickButton(controller, XboxController.Button.kA.value).onTrue(new DrivetoDistance(driveBaseSubsystem, analogPotentiometer));
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return new DrivetoDistance(driveBaseSubsystem, analogPotentiometer);
  }

  
  public void setDefaultCommands() {
    driveBaseSubsystem.setDefaultCommand(arcadeDrive);
  }
}
