package com.tactical.privacy.interfaces;

import com.google.common.base.MoreObjects;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link UserIdentities}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableUserIdentities.builder()}.
 */
@Generated(from = "UserIdentities", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableUserIdentities implements UserIdentities {
  private final String phone;
  private final String email;
  private final long subscriberId;
  private final String visitorId;

  private ImmutableUserIdentities(String phone, String email, long subscriberId, String visitorId) {
    this.phone = phone;
    this.email = email;
    this.subscriberId = subscriberId;
    this.visitorId = visitorId;
  }

  /**
   * @return The value of the {@code phone} attribute
   */
  @Override
  public String getPhone() {
    return phone;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * @return The value of the {@code subscriberId} attribute
   */
  @Override
  public long getSubscriberId() {
    return subscriberId;
  }

  /**
   * @return The value of the {@code visitorId} attribute
   */
  @Override
  public String getVisitorId() {
    return visitorId;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserIdentities#getPhone() phone} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for phone
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserIdentities withPhone(String value) {
    String newValue = Objects.requireNonNull(value, "phone");
    if (this.phone.equals(newValue)) return this;
    return new ImmutableUserIdentities(newValue, this.email, this.subscriberId, this.visitorId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserIdentities#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserIdentities withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableUserIdentities(this.phone, newValue, this.subscriberId, this.visitorId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserIdentities#getSubscriberId() subscriberId} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for subscriberId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserIdentities withSubscriberId(long value) {
    if (this.subscriberId == value) return this;
    return new ImmutableUserIdentities(this.phone, this.email, value, this.visitorId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UserIdentities#getVisitorId() visitorId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for visitorId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableUserIdentities withVisitorId(String value) {
    String newValue = Objects.requireNonNull(value, "visitorId");
    if (this.visitorId.equals(newValue)) return this;
    return new ImmutableUserIdentities(this.phone, this.email, this.subscriberId, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableUserIdentities} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableUserIdentities
        && equalTo(0, (ImmutableUserIdentities) another);
  }

  private boolean equalTo(int synthetic, ImmutableUserIdentities another) {
    return phone.equals(another.phone)
        && email.equals(another.email)
        && subscriberId == another.subscriberId
        && visitorId.equals(another.visitorId);
  }

  /**
   * Computes a hash code from attributes: {@code phone}, {@code email}, {@code subscriberId}, {@code visitorId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + phone.hashCode();
    h += (h << 5) + email.hashCode();
    h += (h << 5) + Longs.hashCode(subscriberId);
    h += (h << 5) + visitorId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UserIdentities} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UserIdentities")
        .omitNullValues()
        .add("phone", phone)
        .add("email", email)
        .add("subscriberId", subscriberId)
        .add("visitorId", visitorId)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link UserIdentities} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UserIdentities instance
   */
  public static ImmutableUserIdentities copyOf(UserIdentities instance) {
    if (instance instanceof ImmutableUserIdentities) {
      return (ImmutableUserIdentities) instance;
    }
    return ImmutableUserIdentities.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableUserIdentities ImmutableUserIdentities}.
   * <pre>
   * ImmutableUserIdentities.builder()
   *    .phone(String) // required {@link UserIdentities#getPhone() phone}
   *    .email(String) // required {@link UserIdentities#getEmail() email}
   *    .subscriberId(long) // required {@link UserIdentities#getSubscriberId() subscriberId}
   *    .visitorId(String) // required {@link UserIdentities#getVisitorId() visitorId}
   *    .build();
   * </pre>
   * @return A new ImmutableUserIdentities builder
   */
  public static ImmutableUserIdentities.Builder builder() {
    return new ImmutableUserIdentities.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableUserIdentities ImmutableUserIdentities}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "UserIdentities", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder implements UserIdentities.Builder {
    private static final long INIT_BIT_PHONE = 0x1L;
    private static final long INIT_BIT_EMAIL = 0x2L;
    private static final long INIT_BIT_SUBSCRIBER_ID = 0x4L;
    private static final long INIT_BIT_VISITOR_ID = 0x8L;
    private long initBits = 0xfL;

    private @Nullable String phone;
    private @Nullable String email;
    private long subscriberId;
    private @Nullable String visitorId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UserIdentities} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(UserIdentities instance) {
      Objects.requireNonNull(instance, "instance");
      phone(instance.getPhone());
      email(instance.getEmail());
      subscriberId(instance.getSubscriberId());
      visitorId(instance.getVisitorId());
      return this;
    }

    /**
     * Initializes the value for the {@link UserIdentities#getPhone() phone} attribute.
     * @param phone The value for phone 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder phone(String phone) {
      this.phone = Objects.requireNonNull(phone, "phone");
      initBits &= ~INIT_BIT_PHONE;
      return this;
    }

    /**
     * Initializes the value for the {@link UserIdentities#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link UserIdentities#getSubscriberId() subscriberId} attribute.
     * @param subscriberId The value for subscriberId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder subscriberId(long subscriberId) {
      this.subscriberId = subscriberId;
      initBits &= ~INIT_BIT_SUBSCRIBER_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link UserIdentities#getVisitorId() visitorId} attribute.
     * @param visitorId The value for visitorId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder visitorId(String visitorId) {
      this.visitorId = Objects.requireNonNull(visitorId, "visitorId");
      initBits &= ~INIT_BIT_VISITOR_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableUserIdentities ImmutableUserIdentities}.
     * @return An immutable instance of UserIdentities
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableUserIdentities build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableUserIdentities(phone, email, subscriberId, visitorId);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_PHONE) != 0) attributes.add("phone");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      if ((initBits & INIT_BIT_SUBSCRIBER_ID) != 0) attributes.add("subscriberId");
      if ((initBits & INIT_BIT_VISITOR_ID) != 0) attributes.add("visitorId");
      return "Cannot build UserIdentities, some of required attributes are not set " + attributes;
    }
  }
}
