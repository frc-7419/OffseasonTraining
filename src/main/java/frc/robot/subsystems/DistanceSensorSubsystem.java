package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DistanceSensorSubsystem extends SubsystemBase {
  // create your private AnalogPotentiometer instance variable
  private AnalogPotentiometer analogPotentiometer;
  public DistanceSensorSubsystem(AnalogPotentiometer analogPotentiometer) {
    // instantiate your sensor
    this.analogPotentiometer = analogPotentiometer;
  }
  
  // make a getDistance method
  public double getDistance() {
    return analogPotentiometer.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Distance", getDistance());
  }
}
