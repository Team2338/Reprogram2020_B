package team.gif.robot.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;
import team.gif.robot.Robot;

public class Shooter extends SubsystemBase {

    private static CANSparkMax flyWheelMotor = new CANSparkMax(RobotMap.FLYWHEEL, CANSparkMaxLowLevel.MotorType.kBrushless);

    private static Shooter instance = null;

    public static Shooter getInstance() {
        if (instance == null) {
            instance = new Shooter();
        }
        return instance;
    }

    private Shooter(){
        super();
        flyWheelMotor.restoreFactoryDefaults();
        flyWheelMotor.enableVoltageCompensation(12);
    }

    public void setVoltage(double voltage){
        flyWheelMotor.setVoltage(voltage);
    }
}
