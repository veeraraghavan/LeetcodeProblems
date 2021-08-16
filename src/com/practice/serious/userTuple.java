/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/14/21, 11:32 PM
 * =========================================
 */

package com.practice.serious;

class userTuple {

  public String getUser() {
    return user;
  }

  public int getVisit() {
    return visit;
  }

  public String getWebsite() {
    return website;
  }

  // @formater:off
  private String user;
  private int visit;
  private String website;
  // @formater:on

  userTuple(String user, int visit, String website) {
    this.user = user;
    this.visit = visit;
    this.website = website;
  }
}
