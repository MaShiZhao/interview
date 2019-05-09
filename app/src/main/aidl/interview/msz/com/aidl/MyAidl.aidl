// MyAidl.aidl
package interview.msz.com.aidl;

// Declare any non-default types here with import statements

import interview.msz.com.aidl.AidlBean;

interface MyAidl {

  void addPerson(in AidlBean bean);

  List<AidlBean> getPersons();

}
