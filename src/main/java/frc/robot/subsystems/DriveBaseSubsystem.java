// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIds;

public class DrivebaseSubsystem extends SubsystemBase {
  /** Creates a new DrivebaseSubsystem. */
  private TalonFX left1;
  private TalonFX left2;
  private TalonFX right1;
  private TalonFX right2;
  private AnalogPotentiometer ultrasonic;
  
  public DrivebaseSubsystem() {
    ultrasonic = new AnalogPotentiometer(0, 500, 0);
    left1 = new TalonFX(CanIds.leftFalcon1.id);
    left2 = new TalonFX(CanIds.leftFalcon2.id);
    right1 = new TalonFX(CanIds.rightFalcon1.id);
    right2 = new TalonFX(CanIds.rightFalcon2.id);

    factoryResetAll();
    
    setAllDefaultInversions();

    left2.follow(left1);
    right2.follow(right1);
  }

  public void setAllMode(NeutralMode mode){
    right1.setNeutralMode(mode);
    right2.setNeutralMode(mode);
    left1.setNeutralMode(mode);
    left2.setNeutralMode(mode);
  }

  public void brake(){setAllMode(NeutralMode.Brake);}

  public void coast(){setAllMode(NeutralMode.Coast);}

  public double getLeftVelocity(){return left1.getSelectedSensorVelocity();}
  public double getRightVelocity(){return right1.getSelectedSensorVelocity();}

  public void setAllDefaultInversions() {
    right1.setInverted(true);
    right2.setInverted(true);
    left1.setInverted(false);
    left2.setInverted(false);
  }

  public void factoryResetAll(){
    right1.configFactoryDefault();
    right2.configFactoryDefault();
    left1.configFactoryDefault();
    left2.configFactoryDefault();
  }


  public void setLeftPower(double power){
    left1.set(ControlMode.PercentOutput, power);
    left2.set(ControlMode.PercentOutput, power);
  }

  public void setRightPower(double power){
    right1.set(ControlMode.PercentOutput, power);
    right2.set(ControlMode.PercentOutput, power);
  }

  public void setAll(double power){
    setLeftPower(power);
    setRightPower(power);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Ultrasonic", ultrasonic.get());
    // System.out.println(ultrasonic.get());
  }

  public double getSensorPosition(){
    return left1.getSelectedSensorPosition();
  }

  public double getUltrasonicDistance(){
    return ultrasonic.get();
  }
}
