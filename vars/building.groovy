/*def call()
{
  sh 'mvn clean install'
} */

#!/usr/bin/env groovy
/*import com.bt.java.BuildConfig */
def call(def body = [:]) 
{
    config = BuildConfig.resolve(body)
    stage('Package')
    {
        withMaven(maven: "${mymaven}")
        {
            script
            {
                try
                {
                    sh "mvn clean install -DskipTests -DskipITs"
                }catch (err)
                {
                    echo 'Error during packaging of REPO ' "${config.GitURL}"
                }
            }
        }
    }
}
