package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CANIds;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveBaseSubsystem extends SubsystemBase {
  // create your private TalonFXs
   /** Creates a new DrivebaseSubsystem. */
  private TalonFX left1;
  private TalonFX left2;
  private TalonFX right1;
  private TalonFX right2;
  private AnalogPotentiometer ultrasonic;
  
  // write your setPower methods
  public DriveBaseSubsystem() {
    ultrasonic = new AnalogPotentiometer(0, 300, 0);
    left1 = new TalonFX(CANIds.leftFalcon1.id);
    left2 = new TalonFX(CANIds.leftFalcon2.id);
    right1 = new TalonFX(CANIds.rightFalcon1.id);
    right2 = new TalonFX(CANIds.rightFalcon2.id);

    factoryResetAll();
    
    setAllDefaultInversions();
    left2.follow(left1);
    right2.follow(right1);
  }

  public void coast() {
    left1.setNeutralMode(NeutralMode.Coast);
    left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);
    right2.setNeutralMode(NeutralMode.Coast);
  }

  public void brake() {
    left1.setNeutralMode(NeutralMode.Brake);
    left2.setNeutralMode(NeutralMode.Brake);
    right1.setNeutralMode(NeutralMode.Brake);
    right2.setNeutralMode(NeutralMode.Brake); 
  }

  public void factoryResetAll() {
    left1.configFactoryDefault();
    left2.configFactoryDefault();
    right1.configFactoryDefault();
    right2.configFactoryDefault();
  }

  public void setAllDefaultInversions() {
    left1.setInverted(false);
    left2.setInverted(false);
    right1.setInverted(true);
    right2.setInverted(true);
  }

  public void setLeftRightPower(double powerLeft, double powerRight) {
    left1.set(ControlMode.PercentOutput, powerLeft);
    left2.set(ControlMode.PercentOutput, powerLeft);
    right1.set(ControlMode.PercentOutput, powerRight);
    right2.set(ControlMode.PercentOutput, powerRight);
  }

  public double getLeftVelocity() {
    return left1.getSelectedSensorVelocity();
  }
  
  public double getRightVelocity() {
    return right1.getSelectedSensorVelocity();
  }

  public double getSensorPosition() {
    return left1.getSelectedSensorPosition();
  }

  public double getUltrasonicDistance() {
    return ultrasonic.get();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("ultrasonic", ultrasonic.get());
  }
  
}
