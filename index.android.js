import React,{Component} from 'react';
import {
  AppRegistry,View,Text,
} from 'react-native';
class ExampleActivity extends Component{
    render(){
        return(
            <View>
                <Text>this is React Native Activity Page</Text>
            </View>
        );
    }
}

class ExampleFragment extends Component{
    render(){
        return(
            <View>
                <Text>this is React Native Fragment Page</Text>
            </View>
        );
    }
}

AppRegistry.registerComponent('PreLoadRNActivity', () => ExampleActivity);

AppRegistry.registerComponent('PreLoadRNFragment', () => ExampleFragment);