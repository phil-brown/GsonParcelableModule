# Gson Parcelable

**Simple GSON Parceling for Android**

This Android library can be used to quickly add the parceling mechanism to a model object. It is not made for speed, but rather for simplicity.

To use GSON for parceling an Object, follow this example:

We have the `Person` class:

````java
public class Person {
	String name;
	String occupation;
	int age;
}
````

First, `extend GsonParcelable`:

````java
public class Person extends GsonParcelable {
	String name;
	String occupation;
	int age;
}
````

Next, create the Gson instance you want to use. This can be the default Gson for simple models, but more complex models may require more customized Gson instances:

````java
public class Person extends GsonParcelable {
	String name;
	String occupation;
	int age;
	
	static Gson sGson = new Gson();
}
````

Finally, create the `CREATOR` field and implement the required methods:

````java
public class Person extends GsonParcelable {
	String name;
	String occupation;
	int age;
	
	static Gson sGson = new Gson();
	
    public static final GsonCreator<Person> CREATOR = new GsonCreator<Person>() {
        @Override
        public Gson getGson() {
            return sGson;
        }
    };

    @Override
    public GsonCreator getCREATOR() {
        return CREATOR;
    }
}
````

That's it! Everything else is handled for you.

## How to import

The easiest way to include this in your project currently is to add as a git submodule in your project's root directory (may wish to fork it), and add a reference in the *gradle.settings* file:

    include ':app', ':gson_parcelable'
    
Then re-sync your gradle files.

----


   Copyright 2015 Phil Brown

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.