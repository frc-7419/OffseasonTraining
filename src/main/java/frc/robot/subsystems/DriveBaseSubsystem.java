package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {
  // create your private TalonFXs
  private TalonFX leftFalcon1;
  private TalonFX rightFalcon1;
  private TalonFX leftFalcon2;
  private TalonFX rightFalcon2;

  public DriveBaseSubsystem() {
    // initialize da motors with CANIds from Constants.java
    leftFalcon1 = new TalonFX(Constants.CANIds.leftFalcon1.id);
    rightFalcon1 = new TalonFX(Constants.CANIds.rightFalcon1.id);
    leftFalcon2 = new TalonFX(Constants.CANIds.leftFalcon2.id);
    rightFalcon2 = new TalonFX(Constants.CANIds.rightFalcon2.id);
  }
  
  // write your setPower methods
  public void setPower(double leftPower, double rightPower) {
    leftFalcon1.set(ControlMode.PercentOutput, leftPower);
    rightFalcon1.set(ControlMode.PercentOutput, rightPower);
    leftFalcon2.set(ControlMode.PercentOutput, leftPower);
    rightFalcon2.set(ControlMode.PercentOutput, rightPower);
  }

  public void brake() {
    leftFalcon1.setNeutralMode(NeutralMode.Brake);
    rightFalcon1.setNeutralMode(NeutralMode.Brake);
    leftFalcon2.setNeutralMode(NeutralMode.Brake);
    rightFalcon2.setNeutralMode(NeutralMode.Brake);
  }
  
  public void coast() {
    rightFalcon1.setNeutralMode(NeutralMode.Coast);
    leftFalcon1.setNeutralMode(NeutralMode.Coast);
    leftFalcon2.setNeutralMode(NeutralMode.Coast);
    rightFalcon2.setNeutralMode(NeutralMode.Coast);
  }
  
  @Override
  public void periodic() {}
}
