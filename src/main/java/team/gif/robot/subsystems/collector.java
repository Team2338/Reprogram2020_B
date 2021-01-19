package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class collector extends SubsystemBase {

    public static collector instance = null;

    public static collector getInstance(){
        if(instance == null) {
            instance = new collector();
        }
        return instance;
    }
    /**
     * Creates a new ExampleSubsystem.
     */
    private static WPI_TalonSRX intakeMotor;

    public collector() {
        intakeMotor = new WPI_TalonSRX(RobotMap.INTAKE);

    }
    public void setSpeed(double motorPercent) {
        intakeMotor.set(ControlMode.PercentOutput,motorPercent);
    }
}
