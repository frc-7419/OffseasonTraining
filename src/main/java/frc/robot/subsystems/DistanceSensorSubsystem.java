package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensorSubsystem extends SubsystemBase {
  // create your private AnalogPotentiometer instance variable
  AnalogPotentiometer distanceSensor;
  public DistanceSensorSubsystem() {
    // instantiate your sensor
    distanceSensor = new AnalogPotentiometer(0, 180, 0);
  }
  
  // make a getDistance method

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Distance", distanceSensor.get())
  }
}
