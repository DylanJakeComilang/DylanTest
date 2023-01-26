package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import java.lang.Math;
import edu.wpi.first.math.controller.PIDController;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ElevatorCommand;

public class ElevatorSubsystem extends SubsystemBase {

    // Objects

    private final CANSparkMax elevatorMotor1 = new CANSparkMax(3, MotorType.kBrushless);
    private final CANSparkMax elevatorMotor2 = new CANSparkMax(6, MotorType.kBrushless);
    private final PIDController PID = new PIDController(0.1, 0, 0);
    private RelativeEncoder relEnc;

    public ElevatorSubsystem() {
        relEnc = elevatorMotor1.getEncoder();
    }

    ///////////////////////////////
    ///         METHODS         ///
    ///////////////////////////////

    // Encoder Methods

    public double getEncoder() {
        return relEnc.getPosition();
    }

    public void resetEncoder() {
        relEnc.setPosition(0);
    }
    
    // PID Method

    public double calculateP(double setpoint){
       return PID.calculate(getEncoder(), setpoint);
    }

    // Teleop Methods

    public void setSpeed(double speed) {
        elevatorMotor1.set(speed);
        elevatorMotor2.set(speed);
    }

    public void setStop() {
        elevatorMotor1.set(0);
        elevatorMotor2.set(0);
    }


    @Override
    public void periodic(){
        
    }

}