package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class Collector extends SubsystemBase {

    private static Collector instance = null;

    public static Collector getInstance(){
        if(instance == null) {
            instance = new Collector();
        }
        return instance;
    }
    /**
     * Creates a new ExampleSubsystem.
     */
    private static final VictorSPX intakeMotor= new VictorSPX(RobotMap.INTAKE);

    public Collector() {
        super();
    }
    public void setSpeed(double motorPercent) {
        intakeMotor.set(ControlMode.PercentOutput,motorPercent);
    }
}
