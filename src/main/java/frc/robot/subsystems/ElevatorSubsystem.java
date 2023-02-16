package frc.robot.subsystems;

import com.fasterxml.jackson.core.io.OutputDecorator;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorSubsystem extends SubsystemBase {
 
    // Objects

    private final CANSparkMax elevatorMotor1 = new CANSparkMax(3,
            MotorType.kBrushless);
    private final CANSparkMax elevatorMotor2 = new CANSparkMax(6,
            MotorType.kBrushless);
    private final PIDController PID = new PIDController(0.14, 0.01, 0.001); //0.14 , 0.01
    private RelativeEncoder relEnc;
    private double errorPos = 0;
    private double calc;
    private double setPoint;

    public ElevatorSubsystem() {
        relEnc = elevatorMotor1.getEncoder();
        PID.setTolerance(0.1);
    }

    ///////////////////////////////         //  //  //////   //     // 
    ///         METHODS         ///         //////  //  //   // / //
    ///////////////////////////////         //  //  //////   // //

    // Encoder Methods

    public double getEncoder() {
        return relEnc.getPosition();
    }

    public void resetEncoder() {
        relEnc.setPosition(0);
    }

    // PID Methods

    public double calculateP(double setpoint) {
        double calc = PID.calculate(getEncoder(), setpoint);
        if (PID.atSetpoint()) {
            return 0;
        }
        if (calc > 0.5) {
            return 0.5;
        } else if (calc < -0.5) {
            return -0.5;
        } else {
            return calc;
        }
    }

    public void stopI() {
        double currentPos = PID.getPositionError();
        if (currentPos > 0 && errorPos < 0) {
            PID.reset();
        } else if (currentPos < 0 && errorPos > 0) {
            PID.reset();
        }
        errorPos = PID.getPositionError();
    }

    public void outputMotor(double setpoint) {
        setPoint = setpoint;
        calc = calculateP(setpoint);
        elevatorMotor1.set(calc);
        elevatorMotor2.set(calc);
        stopI();
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
    public void periodic() {
        SmartDashboard.putNumber("elevator enc", getEncoder());
        SmartDashboard.putNumber("Encoder Counts", getEncoder());
        SmartDashboard.putNumber("ErrorValue", PID.getPositionError());
        SmartDashboard.putNumber("Output Motor", calc);
        SmartDashboard.putNumber("Setpoint", setPoint);
    }

}