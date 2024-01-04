package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DistanceSensorSubsystem extends SubsystemBase {

    private AnalogPotentiometer distanceSensor;
    private PIDController pidController;

    public DistanceSensorSubsystem(int analogInputPort, PIDController pidController) {
        distanceSensor = new AnalogPotentiometer(analogInputPort);
        this.pidController = pidController;
    }

    public double getDistance() {
        return distanceSensor.get();
    }

    public double getPIDOutput(double setpoint) {
        return pidController.calculate(getDistance(), setpoint);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Distance", getDistance());
    }
}
