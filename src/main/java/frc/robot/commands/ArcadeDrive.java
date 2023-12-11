package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBaseSubsystem;
import edu.wpi.first.wpilibj.XboxController;


public class ArcadeDrive extends CommandBase {


  private DriveBaseSubsystem driveBaseSubsystem;
  private XboxController joystick;
  public ArcadeDrive(DriveBaseSubsystem driveBaseSubsystem, XboxController joystick) {
    this.joystick = joystick;
    this.driveBaseSubsystem = driveBaseSubsystem;
    addRequirements(driveBaseSubsystem);
  }
  @Override
  public void initialize() {
  }
  @Override
  public void execute() {
    double drivebasepower = joystick.getLeftX()*0.3;
    if (joystick.getLeftX()>0.05){
      
      driveBaseSubsystem.coast();
      driveBaseSubsystem.setPower(drivebasepower);
    }
  }
  @Override
  public void end(boolean interrupted) {
    driveBaseSubsystem.setPower(0);
    driveBaseSubsystem.brake();
  }
  @Override
  public boolean isFinished(){
    return false;
  }
}