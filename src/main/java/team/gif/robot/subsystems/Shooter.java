package team.gif.robot.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.Constants;
import team.gif.robot.RobotMap;
import team.gif.robot.Robot;

public class Shooter extends SubsystemBase {

    // Create CanSparkMax, CANPIDController, and CANEncoder objects
    private static final CANSparkMax flyWheelMotor = new CANSparkMax(RobotMap.FLYWHEEL, CANSparkMaxLowLevel.MotorType.kBrushless);
    private static final CANPIDController flyWheelPIDController = flyWheelMotor.getPIDController();
    private static final CANEncoder flyWheelEncoder = flyWheelMotor.getEncoder();

    private static Shooter instance = null;

    // Create instance method to ensure only 1 instance of shooter
    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }

    // Constructor
    private Shooter(){
        super();
        flyWheelMotor.restoreFactoryDefaults();
        flyWheelMotor.enableVoltageCompensation(12);
        flyWheelMotor.setIdleMode(CANSparkMax.IdleMode.kCoast); // Slows down slowly

        flyWheelPIDController.setP(Constants.Shooter.kP);
        flyWheelPIDController.setFF(Constants.Shooter.kF);
        flyWheelPIDController.setOutputRange(0, 1);
    }

    // Controls the voltage of the motor (used to power off motor
    public void setVoltage(double voltage){
        flyWheelMotor.setVoltage(voltage);
    }

    // Used to set RPM of the motor
    public void setRPM(double setPoint){flyWheelPIDController.setReference(setPoint, ControlType.kVelocity);}

    // Get the speed of the motor
    public double getVelocity(){return flyWheelEncoder.getVelocity();}

    public String getVelocityAsString(){return String.format("%12.0f", getVelocity());}
}

