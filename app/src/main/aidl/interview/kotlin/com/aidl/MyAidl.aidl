// MyAidl.aidl
package interview.kotlin.com.aidl;

// Declare any non-default types here with import statements

import interview.kotlin.com.aidl.AidlBean;

interface MyAidl {

  void addPerson(in AidlBean bean);

  List<AidlBean> getPersons();

}
